---
layout: default
title: "graphql-java"
---

This is a GraphQL Java implementation based on the [specification](https://github.com/facebook/graphql) 
and the JavaScript [reference implementation](https://github.com/graphql/graphql-js).

See the [README](https://github.com/graphql-java/graphql-java/blob/master/README.md) for complete documentation.

### Hello World

This is the famous "hello world" in graphql-java: 

```java
import graphql.schema.GraphQLObjectType;
import graphql.schema.GraphQLSchema;

import static graphql.Scalars.GraphQLString;
import static graphql.schema.GraphQLFieldDefinition.newFieldDefinition;
import static graphql.schema.GraphQLObjectType.newObject;

public class HelloWorld {

    public static void main(String[] args) {
    
        GraphQLObjectType queryType = newObject()
                        .name("helloWorldQuery")
                        .field(newFieldDefinition()
                                .type(GraphQLString)
                                .name("hello")
                                .staticValue("world")
                                .build())
                        .build();
        
        GraphQLSchema schema = GraphQLSchema.newSchema()
                        .query(queryType)
                        .build();
        Map<String, Object> result = new GraphQL(schema).execute("{hello}").getData();
        
        System.out.println(result);
        // Prints: {hello=world}
    }
}
```

[![Build Status](https://travis-ci.org/graphql-java/graphql-java.svg?branch=master)](https://travis-ci.org/graphql-java/graphql-java)
[![Latest Release](https://maven-badges.herokuapp.com/maven-central/com.graphql-java/graphql-java/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.graphql-java/graphql-java/)
[![Latest Dev Build](https://api.bintray.com/packages/andimarek/graphql-java/graphql-java/images/download.svg)](https://bintray.com/andimarek/graphql-java/graphql-java/_latestVersion)