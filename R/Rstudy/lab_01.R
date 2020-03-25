# 문제 1
v1 <- 1:10
v2 <- 2*v1
max_v <- max(v2)
min_v <- min(v2)
avg_v <- mean(v2)
sum_v <- sum(v2)
v3 <- v2[-5]
v1;v2;v3;max_v;min_v;avg_v;sum_v

# 문제2
v4 <- 2*seq(5)-1 ## seq(1,9,2) 로 할 수 도 있다.
v5 <- rep(1,5)
v6 <- rep(1:3,3)
v7 <- rep(1:4,each=2)
v4;v5;v6;v7

#문제3
nums <- sample(1:100,10)
sort(nums)
sort(nums,decreasing = TRUE)
nums[nums > 50]
which(nums<=50)
which(nums==max(nums))
which(nums==min(nums))

#문제4
v8 <- seq(1,10,by=3)
names(v8) <- LETTERS[1:4]
v8

#문제5
score <- sample(1:20,5)
myFriend <- c("둘리","또치","도우너","희동","듀크")
paste(score,myFriend,sep = "-")
myFriend[score==max(score)]
myFriend[score==min(score)]
myFriend[score>10]