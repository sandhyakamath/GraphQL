This is a GraphQL demo project.<br/>
GraphQL is Query Language for APIs and is server-side runtime for executing queries by using type system.<br/>
It allows to request exactly the data needed and resolves over fetching and under fetching data with REST endpoints.<br/>

<H3>GraphQLDemo</H3>

Created GraphQL Schema: Defines the types of data you can query and the relationships between those types.<br/>
GraphQL Resolver functions which provide the instructions for turning a GraphQL operation into data.<br/>

Querying GraphQL with url http://localhost:8082/graphql
<br/>
{<br/>
    &nbsp;&nbsp;&nbsp; getPerson(id: 1) { <br/>
     &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  id<br/>
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  name<br/>
       &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;email<br/>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;bills {<br/>
         &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;  id<br/>
          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  description<br/>
           &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; amount<br/>
       &nbsp; &nbsp;}<br/>
   &nbsp; }<br/>
}<br/>


<H3>Person Service:</H3> Manages personal information such as name, email, and a list of bills associated with the person. Started in the port 8081<br/>

<H3>Bill Service:</H3> Manages billing information and retrieves bills associated with a person.Started in the port 8080<br/>

