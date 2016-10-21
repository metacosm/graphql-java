package graphql.schema;


/**
 * A special type to allow a object/interface types to reference itself. It's replaced with the real type
 * object when the schema is build.
 */
public class GraphQLTypeReference extends AbstractGraphQLType implements GraphQLType, GraphQLOutputType {

    public GraphQLTypeReference(String name) {
        super(name, null);
    }
}
