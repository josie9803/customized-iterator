@ECHO OFF
FOR /L %%G IN (1,1,9) DO (
   ECHO javac testcases/Test0%%G.java
   javac testcases/Test0%%G.java
   java testcases.Test0%%G
)

FOR /L %%G IN (10,1,40) DO (
   ECHO javac testcases/Test%%G.java
   javac testcases/Test%%G.java
   java testcases.Test%%G
)
