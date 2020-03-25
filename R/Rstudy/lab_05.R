#문제1
#1.
grade <- sample(1:6,1)
grade
#2.
grade <- as.character(grade)
switch(EXPR = grade,"1"=,"2"=,"3"=paste(grade,"학년은 저학년입니다."),
        "4"=,"5"=,"6"=paste(grade,"학년은 고학년입니다."))
#문제2.
#1.
choice <- sample(1:5,1)
choice
#2.
result <- switch(EXPR = choice,300+50,300-50,300*50,300/50,300%%50)
#3.
cat("결과값 : ",result,"\n")

#문제3.
#1.
count <- sample(3:10,1)
count
#2.
deco <- sample(1:3,1)
deco
#3.
symbol <- switch(EXPR = deco,"1"="*","2"="$","3"="#")
for(i in 1:count){
  cat(symbol)
}

#문제4.
#1.
score <- sample(1:100,1)
#2.
score1 <- as.character(score%/%10)
level <- switch(EXPR = score1,
               "10"=,"9"="A",
               "8"="B",
               "7"="C",
               "6"="D","F")
cat(score," 점은 ",level," 등급입니다.")

#문제5.
alpha <- paste(LETTERS,letters,sep="")
print(alpha)