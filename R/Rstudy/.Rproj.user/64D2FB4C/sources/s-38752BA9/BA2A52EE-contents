#[ 문제9 ] – 함수 문제 아님
#iotest2.txt 파일에 저장된 데이터들을 읽고 다음과 같은 형식으로 결과를 출력하는
#R 코드를 구현하고 test1.R 로 저장하여 제출한다.

data2 <- scan("data/iotest2.txt",what="")
keyList <- vector()
data2 <- sort(data2)
data2
keyList <- data2[1]
for(i in 2:length(data2)){
  if(data2[i]!=data2[i-1]){
    keyList <- c(keyList,data2[i])
  }
}
keyList
countList <- rep(1,length(keyList))
inx <- 1
for(i in 2:length(data2)){
  if(data2[i]==data2[i-1]){
    countList[inx] <- countList[inx]+1
  }
  else{
    inx <- inx+1
  }
}
maxInx <- which.max(countList)
paste0("가장 많이 등장한 단어는 ",keyList[maxInx]," 입니다")
