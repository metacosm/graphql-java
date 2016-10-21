package graphql.schema;


import static graphql.Assert.assertNotNull;

public class GraphQLScalarType extends AbstractGraphQLType implements GraphQLType, GraphQLInputType, GraphQLOutputType,
        GraphQLUnmodifiedType,
        GraphQLNullableType {

    private final Coercing coercing;


    public GraphQLScalarType(String name, String description, Coercing coercing) {
        super(name, description);
        assertNotNull(coercing, "coercing can't be null");
        this.coercing = coercing;
    }

    public Coercing getCoercing() {
        return coercing;
    }

    @Override
    public String toString() {
        return "GraphQLScalarType{" +
                "name='" + getName() + '\'' +
                ", description='" + getDescription() + '\'' +
                ", coercing=" + coercing +
                '}';
    }
}
