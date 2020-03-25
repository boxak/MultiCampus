# 문제1.
View(airquality)
nrow(airquality);colnames(airquality)
# -> str(airquality)

# 문제2.
df1 <- data.frame(x=1:5,y=2*seq(1,5))
df1

# 문제3.
df2 <- data.frame(
  col1 = 1:5,
  col2 = letters[1:5],
  col3 = 6:10
)
df2

# 문제4.
productName <- c("사과","딸기","수박")
price <- c(1800,1500,3000)
sold <- c(24,38,13)

df3 <- data.frame(제품명 = productName,가격 = price,판매량 = sold,stringsAsFactors = FALSE)
df3

# 문제5.
priceMean <- mean(df3$가격)
priceMean
soldMean <- mean(df3$판매량)
soldMean

# 문제6.
name <- c("Potter","Elsa","Gates","Wendy","Ben")
gender <- factor(c("M","F","M","F","M"))
math <- c(85,76,99,88,40)

df4 <- data.frame(name,gender,math,stringsAsFactors = FALSE)
df4

class(df4$name)
class(df4$gender)
class(df4$math)

#(a)
df4$stat <- c(76,73,95,82,35)
#(b)
df4$score <- df4$math+df4$stat
df4
#(c)
df4$grade <- ifelse(df4$score>=150,"A",
                    ifelse(df4$score>=100 & df4$score<150,"B",
                           ifelse(df4$score>=70 & df4$score<100,"C","D")))     
df4

# 문제7.
str(emp)
# 문제8.
emp[3:5,]
# 문제9.
emp$ename
# 문제10.
emp[,c("ename","sal")]
# 문제11.
subset(emp,select = c(ename,sal,job),subset=emp$job=="SALESMAN")
# 문제12.
subset(emp,select = c(ename,sal,deptno),subset=emp$sal>=1000 & emp$sal<=3000)
# 문제13.
subset(emp,select = c(ename,job,sal),subset=emp$job!="ANALYST")
# 문제14.
emp$job
emp[,c(ename,job)]
emp[emp$job=="SALESMAN" | emp$job=="ANALYST",c("ename","job")]
# 문제15.
emp[is.na(emp$comm),c("ename","sal")]
# 문제16.
order(emp$sal)
emp[order(emp$sal),]