package graphql.schema;

import static graphql.Assert.assertNotNull;

/**
 * @author Christophe Laprun
 */
public class AbstractGraphQLType implements GraphQLType {
    private final String name;
    private final String description;

    AbstractGraphQLType(String name, String description) {
        assertNotNull(name, "name can't be null");
        this.description = description;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AbstractGraphQLType)) return false;
        AbstractGraphQLType that = (AbstractGraphQLType) o;
        return this.name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
