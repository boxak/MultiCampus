library(RSelenium)

remDr <- remoteDriver(remoteServerAddr = "localhost",
                      port = 4445,
                      browserName = "chrome")
remDr$open()
remDr$navigate("http://comic.naver.com/comment/comment.nhn?titleId=570503&no=135")

bestReviewNodes <- remDr$findElements(using = "css selector","div.u_cbox_text_wrap > span.u_cbox_contents")
bestReviewTexts <- sapply(bestReviewNodes,function(x){x$getElementText()})
#cbox_module > div > div.u_cbox_paginate > div > a:nth-child(4)

totalReview <- remDr$findElement(using = "css selector","#cbox_module > div > div.u_cbox_sort > div.u_cbox_sort_option > div > ul > li:nth-child(2) > a")
totalReview$clickElement()

totalReviewTexts <- vector()
for(i in 1:5){
  for(j in 3:12){
    tempReviewNodes <- NULL
    tempReviewTexts <- NULL
    tempReviewNodes <- remDr$findElements(using = "css selector","div.u_cbox_text_wrap > span.u_cbox_contents")
    tempReviewTexts <- sapply(tempReviewNodes,function(x){x$getElementText()})
    totalReviewTexts <- c(totalReviewTexts,tempReviewTexts)
    nextButtonTag <- remDr$findElement(using = "css selector",paste0("#cbox_module > div > div.u_cbox_paginate > div > a:nth-child(",j+1,")"))
    nextButtonTag$clickElement()
    print(tempReviewTexts)
    print(length(tempReviewTexts))
    Sys.sleep(2)
  }
}
length(totalReviewTexts)

webtoon1 <- c(bestReviewTexts,totalReviewTexts)
webtoon1 <- unlist(webtoon1)
write(webtoon1,file = "webtoon1.txt",sep = "\n")
