This is a GraphQL demo project.
GraphQL is Query Language for APIs and is server-side runtime for executing queries by using type system.
It allows to request exactly the data needed and resolves over fetching and under fetching data with REST endpoints.

GraphQLDemo

Created GraphQL Schema: Defines the types of data you can query and the relationships between those types.
GraphQL Resolver functions which provide the instructions for turning a GraphQL operation into data.

Querying GraphQL with url http://localhost:8082/graphql port started in 8082
{
    getPerson(id: 1) {
        id
        name
        email
        bills {
            id
            description
            amount
        }
    }
}


Person Service: Manages personal information such as name, email, and a list of bills associated with the person.

Bill Service: Manages billing information and retrieves bills associated with a person.
