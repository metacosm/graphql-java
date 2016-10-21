package graphql.schema;

import java.util.ArrayList;
import java.util.List;

import static graphql.Assert.assertNotNull;

public class GraphQLObjectType extends AbstractGraphQLFieldsContainer implements GraphQLType, GraphQLOutputType,
        GraphQLFieldsContainer, GraphQLCompositeType, GraphQLUnmodifiedType, GraphQLNullableType {

    private final List<GraphQLInterfaceType> interfaces = new ArrayList<GraphQLInterfaceType>();

    public GraphQLObjectType(String name, String description, List<GraphQLFieldDefinition> fieldDefinitions, List<GraphQLInterfaceType> interfaces) {
        super(name, description, fieldDefinitions);

        assertNotNull(interfaces, "interfaces can't be null");
        this.interfaces.addAll(interfaces);
    }

    public List<GraphQLInterfaceType> getInterfaces() {
        return new ArrayList<GraphQLInterfaceType>(interfaces);
    }

    @Override
    public String toString() {
        return "GraphQLObjectType{" +
                "name='" + getName() + '\'' +
                ", description='" + getDescription() + '\'' +
                ", fieldDefinitionsByName=" + getFieldsMap() +
                ", interfaces=" + interfaces +
                '}';
    }

    public static Builder newObject() {
        return new Builder();
    }


    public static class Builder {
        private String name;
        private String description;
        private List<GraphQLFieldDefinition> fieldDefinitions = new ArrayList<GraphQLFieldDefinition>();
        private List<GraphQLInterfaceType> interfaces = new ArrayList<GraphQLInterfaceType>();

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder field(GraphQLFieldDefinition fieldDefinition) {
            assertNotNull(fieldDefinition, "fieldDefinition can't be null");
            this.fieldDefinitions.add(fieldDefinition);
            return this;
        }

        /**
         * Take a field builder in a function definition and apply. Can be used in a jdk8 lambda
         * e.g.:
         * <pre>
         *     {@code
         *      field(f -> f.name("fieldName"))
         *     }
         * </pre>
         *
         * @param builderFunction a supplier for the builder impl
         * @return this
         */
        public Builder field(BuilderFunction<GraphQLFieldDefinition.Builder> builderFunction) {
            assertNotNull(builderFunction, "builderFunction can't be null");
            GraphQLFieldDefinition.Builder builder = GraphQLFieldDefinition.newFieldDefinition();
            builder = builderFunction.apply(builder);
            return field(builder.build());
        }

        /**
         * Same effect as the field(GraphQLFieldDefinition). Builder.build() is called
         * from within
         *
         * @param builder an un-built/incomplete GraphQLFieldDefinition
         * @return this
         */
        public Builder field(GraphQLFieldDefinition.Builder builder) {
            this.fieldDefinitions.add(builder.build());
            return this;
        }

        public Builder fields(List<GraphQLFieldDefinition> fieldDefinitions) {
            assertNotNull(fieldDefinitions, "fieldDefinitions can't be null");
            this.fieldDefinitions.addAll(fieldDefinitions);
            return this;
        }

        public Builder withInterface(GraphQLInterfaceType interfaceType) {
            assertNotNull(interfaceType, "interfaceType can't be null");
            this.interfaces.add(interfaceType);
            return this;
        }

        public Builder withInterfaces(GraphQLInterfaceType... interfaceType) {
            for (GraphQLInterfaceType type : interfaceType) {
                withInterface(type);
            }
            return this;
        }

        public GraphQLObjectType build() {
            return new GraphQLObjectType(name, description, fieldDefinitions, interfaces);
        }


    }
}
