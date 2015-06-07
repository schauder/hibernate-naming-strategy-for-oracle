The default Naming Strategy of Hibernate creates arbitrary long names, which do not work with Oracle which has a (very annoying) limit of 30 characters for names.

This naming strategy creates abbreviation in order to limit the name length, resulting in legal oracle names, which are still (somewhat) readable.

In order to use the Oracle Naming Strategy you have to do two things:
1. download the single Source File from the Downloads and put it in a source directory in your project in a package named 'de.schauderhaft.hibernate'.

2. specify it as the NamingStrategy to use. One way to do that would be to pass an instance to the Configuration instance before you create a SessionFactory:

```
SessionFactory sf = new Configuration()
    .setNamingStrategy(new OracleNamingStrategy());
```