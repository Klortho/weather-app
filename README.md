## Sample App : Spring MVC training ###

1. Adhering to https://confluence.ncbi.nlm.nih.gov/display/coreweb/Spring+MVC+Training+project
2. Currently used JSP
3. The models use XStream, which requires an ORM of sorts. The approach is long-winded, but XStream seems
like a useful package for writing RESTful services.
4. Unit tests are written using (i) Mockito (2 tests) (ii) MockMvc (4 tests). MockMvc is less verbose, more suitable.