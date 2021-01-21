# Java_QA

## Level 0. Zero - Подготовка

#### 0.1. Git

##### Урок 01. Введение

### Usage

The following code demonstrates basic usage of EF Core. For a full tutorial configuring the `DbContext`, defining the model, and creating the database, see [getting started](https://docs.microsoft.com/ef/core/get-started/) in the docs.

```cs
using (var db = new BloggingContext())
{
    // Inserting data into the database
    db.Add(new Blog { Url = "http://blogs.msdn.com/adonet" });
    db.SaveChanges();

    // Querying
    var blog = db.Blogs
        .OrderBy(b => b.BlogId)
        .First();

    // Updating
    blog.Url = "https://devblogs.microsoft.com/dotnet";
    blog.Posts.Add(
        new Post
        {
            Title = "Hello World",
            Content = "I wrote an app using EF Core!"
        });
    db.SaveChanges();

    // Deleting
    db.Remove(blog);
    db.SaveChanges();
}
```

Microsoft.Data.Sqlite
--------------------
