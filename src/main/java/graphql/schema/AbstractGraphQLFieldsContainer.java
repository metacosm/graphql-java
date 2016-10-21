package graphql.schema;

import graphql.AssertException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static graphql.Assert.assertNotNull;

/**
 * @author Christophe Laprun
 */
public class AbstractGraphQLFieldsContainer extends AbstractGraphQLType implements GraphQLFieldsContainer {
    private final Map<String, GraphQLFieldDefinition> fieldDefinitionsByName;

    AbstractGraphQLFieldsContainer(String name, String description, List<GraphQLFieldDefinition> fieldDefinitions) {
        super(name, description);
        assertNotNull(fieldDefinitions, "fieldDefinitions can't be null");
        this.fieldDefinitionsByName = new HashMap<String, GraphQLFieldDefinition>(fieldDefinitions.size());
    }

    private void buildDefinitionMap(List<GraphQLFieldDefinition> fieldDefinitions) {
        for (GraphQLFieldDefinition fieldDefinition : fieldDefinitions) {
            String name = fieldDefinition.getName();
            if (fieldDefinitionsByName.containsKey(name))
                throw new AssertException("field " + name + " redefined");
            fieldDefinitionsByName.put(name, fieldDefinition);
        }
    }

    public GraphQLFieldDefinition getFieldDefinition(String name) {
        return fieldDefinitionsByName.get(name);
    }


    public List<GraphQLFieldDefinition> getFieldDefinitions() {
        return new ArrayList<GraphQLFieldDefinition>(fieldDefinitionsByName.values());
    }

    protected Map<String, GraphQLFieldDefinition> getFieldsMap() {
        return fieldDefinitionsByName;
    }
}
