package graphql.schema;


public class GraphQLList extends AbstractGraphQLModifiedType implements GraphQLType, GraphQLInputType,
        GraphQLOutputType, GraphQLModifiedType, GraphQLNullableType {

    public GraphQLList(GraphQLType wrappedType) {
        super(wrappedType);
    }
}
