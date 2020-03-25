#문제1.
L1 <- list("scott",3000)
result1 <- L1[[2]]*2
L1;result1

#문제2.
L2 <- list("scott",c(100,200,300))
L2

#문제3.
L3 <- list(c(3,5,7),c("A","B","C"))
L3[[2]][1] <- "Alpha"
L3

#문제4.
L4 <- list(
  alpha = 0:4,
  beta = sqrt(1:5),
  gamma = log(1:5)
)
L4[[1]]+10

#문제5.
L5 <- list(
  math=list(95,90),
  writing=list(90,85),
  reading=list(85,80)
)
## unlist를 하면 list 안의 list도 unlist된다.
L5$avg = list(mean(unlist(L5$math)),mean(unlist(L5$writing)),
              mean(unlist(L5$reading)))
mean(unlist(L5$avg))

#문제6.
time <- 32150
timeInfo <- list(
  hour = time%/%3600,
  min = (time%%3600)%/%60,
  sec = time%%60
)
paste(timeInfo$hour,"시간 ",timeInfo$min,"분 ",timeInfo$sec,"초")