package graphql.schema;

import java.util.Map;

import static graphql.Assert.assertNotNull;

/**
 * @author Christophe Laprun
 */
public class AbstractGraphQLModifiedType implements GraphQLModifiedType {
    private GraphQLType wrappedType;

    public AbstractGraphQLModifiedType(GraphQLType wrappedType) {
        assertNotNull(wrappedType, "wrappedType can't be null");
        this.wrappedType = wrappedType;
    }

    public GraphQLType getWrappedType() {
        return wrappedType;
    }

    void replaceTypeReferences(Map<String, GraphQLType> typeMap) {
        wrappedType = new SchemaUtil().resolveTypeReference(wrappedType, typeMap);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AbstractGraphQLModifiedType that = (AbstractGraphQLModifiedType) o;

        return !(wrappedType != null ? !wrappedType.equals(that.wrappedType) : that.wrappedType != null);

    }

    @Override
    public int hashCode() {
        return wrappedType != null ? wrappedType.hashCode() : 0;
    }

    @Override
    public String getName() {
        return null;
    }
}