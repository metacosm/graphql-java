package graphql.schema;


public class GraphQLNonNull extends AbstractGraphQLModifiedType implements GraphQLType, GraphQLInputType,
        GraphQLOutputType,
        GraphQLModifiedType {

    public GraphQLNonNull(GraphQLType wrappedType) {
        super(wrappedType);
    }

    @Override
    public String toString() {
        return "GraphQLNonNull{" +
                "wrappedType=" + getWrappedType() +
                '}';
    }
}
