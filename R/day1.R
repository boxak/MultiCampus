# R 공부 열심히 하장~
v1 <- 1:10
v2 <- v1+100
print(v2)

v1 <- c(4, 1, 8, 6, 10)
print(v1)
## 변수명만 넣으면 자동으로 print함수가 실행.
v1
?rep #help()함수와 동일한 결과가 나온다.
rep(1, 100) ##첫번째 argument를 100번 반복한다.
rep(1:3, 5) ## (1,2,3)을 5번 반복한다.
rep(1:3, times=5)
## R은 변수명을 파라미터에 넣을 수 있다. -> 키워드 파라미터라 한다.
rep(1:3, each=5) ## 1을 5번, 2를 5번, 3을 5번 반복한다.

LETTERS
letters
month.name
month.abb
pi

LETTERS;letters;month.name;month.abb;pi

LETTERS[1]; LETTERS[c(1)];LETTERS[3:5] ## -> LETTERS[c(3,4,5)]와 같은 의미
LETTERS[-1]; LETTERS[c(-2,-4)] ## 첫번째만 빼고 추출하란 의미
## 두번째, 네번째만 빼고 추출하란 의미.

length(LETTERS)
length(month.name)
length(pi)


x <- c(10,2,7,4,15)
x
print(x)
class(x)
rev(x) # 현재 순서의 역순으로 뒤집는다.
range(x) # 범위
sort(x)
sort(x, decreasing = TRUE)
sort(x, decreasing = T)
#x <- sort(x)
order(x)
# 정렬하되, 인덱스 번호를 써놓는다.

x[3] <- 20
x
x + 1
x <- x + 1
x
max(x);min(x);mean(x);sum(x)
summary(x)
## -> named vector가 출력된다. 원소마다 이름이 붙여짐.
x[c(2,4)] # x[2], x[4]
x[c(F,T,F,T,F)] # x[c(T,F)]
## -> True인 원소만 출력한다.
## c(T,F) -> T,F,T,F,T 로 채운다.
x[c(F,T)]
x > 5 ## 각 원소마다 비교한다.
x[x > 5]
x[x > 5 & x < 15] ## &&, || 을 쓰지 않는다. 한개만 쓴다.
## 두 개짜리로 비교하면 첫번째 원소만 비교해서 전체에 적용한다.
x[x > 5 | x < 15]

names(x) ## argument로 주어진 벡터의 name을 추출한다.
names(x) <- LETTERS[1:5]
x
names(x)
names(x) <- NULL
x[2];x["B"]

# &, &&
c(T, T, F, F) & c(T, F, T, F)
c(T, T, F, F) | c(T, F, T, F)
c(T, T, F, F) && c(T, F, T, F)
c(T, T, F, F) || c(T, F, T, F)


ls() ## 지금까지 만든 객체 리스트를 보여준다.
rm(x)
x
class(x)

rainfall <- c(21.6, 23.6, 45.8, 77.0, 
              102.2, 133.3,327.9, 348.0, 
              137.6, 49.3, 53.0, 24.9)
rainfall > 100
rainfall[rainfall > 100]
which(rainfall > 100) ## 몇 월이 100보다 강수량이 큰 월인지 알고싶을때 사용
month.name[which(rainfall > 100)]
month.abb[which(rainfall > 100)]
month.korname <- c("1월","2월","3월",
                   "4월","5월","6월",
                   "7월","8월","9월",
                   "10월","11월","12월")
month.korname[which(rainfall > 100)]
which.max(rainfall)
which.min(rainfall)
month.korname[which.max(rainfall)]
month.korname[which.min(rainfall)]


sample(1:20, 3)
sample(1:45, 6)
sample(1:10, 7)
sample(1:10, 7, replace=T) ## replace = T : 중복 허용

count <- sample(1:100,7)
month.korname <- c("일요일", "월요일", "화요일",
                   "수요일", "목요일", 
                   "금요일", "토요일")

paste(month.korname, count, sep = ":") ## default는 공백임.
month.korname[which.max(count)]
month.korname[which.min(count)]
month.korname[which(count > 50)]

paste(month.korname, count, sep = " : ")

paste("I'm","Duli","!!")
paste("I'm","Duli","!!", sep="")
paste0("I'm","Duli","!!")

fruit <- c("Apple", "Banana", "Strawberry")
food <- c("Pie","Juice", "Cake")
paste(fruit, food)

paste(fruit, food, sep="")
paste(fruit, food, sep=":::")
paste(fruit, food, sep="", collapse="-")
paste(fruit, food, sep="", collapse="")
paste(fruit, food, collapse=",")