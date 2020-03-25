#문제1.
exam1 <- function(){
  return(paste(LETTERS,letters,sep = ""))
}
result1 <- exam1()
result1

#문제2.
exam2 <- function(x){
  return(sum(1:x)) #R에는 복합대입연산자가 존재하지 X.
}
result2 <- exam2(100)
result2

#문제3.
exam3 <- function(x,y){
  return(abs(y-x))
}
result3 <- exam3(30,20)
result3

#문제4.
exam4 <- function(x,op,y){
  result <- switch(
    EXPR = op,
    "+"=x+y,
    "-"=x-y,
    "*"=x*y,
    ifelse(x==0,"오류1",
           ifelse(y==0,"오류2",
                  ifelse(op=="%/%",x%/%y,
                         ifelse(op=="%%",x%%y,"규격의 연산자만 전달하세요"))))
  )
  return(result)
}
result4 <- exam4(0,"/",103)
result4

#문제5.
exam5 <- function(count,str="#"){
  if(count>0){
    for(i in 1:count){
      cat(str)
    }
  }
  return()
}
exam5(count=-1,str="%")

#문제6.
exam6 <- function(data){
  for(i in 1:length(data)){
    if(is.na(data[i])){
      print("NA는 처리불가")
      next
    }
    else if(data[i]>=85 & data[i]<=100){
      print(paste0(data[i],"점은 ","상등급입니다."))
    }
    else if(data[i]<85 & data[i]>=70){
      print(paste0(data[i],"점은 ","중등급입니다."))
    }
    else if(data[i]<70){
      print(paste0(data[i],"점은 ","하등급입니다."))
    }
  }
}
score <- c(100,,36,70,91,,31)
exam6(score)