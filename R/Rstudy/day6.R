# 정규표현식 사용
word <- "JAVA javascript Aa 가나다 AAaAaA123 %^&*"
gsub(" ", "", word);sub(" ","-",word)
# sub는 최초로 찾은 곳만 적용한다.
gsub("A", "", word) 
gsub("a", "", word) 
gsub("Aa", "", word) 
gsub("(Aa)", "", word) 
gsub("(Aa){2}", "", word);gsub("Aa{2}","",word)
# -> Aaa를 찾는다. {}안에 숫자를 넣으면 몇 번 반복 의미.
gsub("[Aa]", "", word) 
#대괄호는 or의 의미
gsub("[가-힣]", "", word) 
gsub("[^가-힣]", "", word) #한글이 아닌 패턴 찾기.
gsub("[&^%*]", "", word) 
gsub("[[:punct:]]", "", word) 
gsub("[[:alnum:]]", "", word) 
gsub("[1234567890]", "", word) 
gsub("[0-9]", "", word) 
gsub("\\d", "", word)
gsub("[[:digit:]]", "", word) 
gsub("[^[:alnum:]]", "", word) 
gsub("[[:space:]]", "", word) 


# 동적 크롤링
install.packages('RSelenium')
library(RSelenium)
remDr <- remoteDriver(remoteServerAddr = "localhost",
                      port = 4445,
                      browserName = "chrome")
remDr$open()

#구글 검색
remDr$navigate("http://www.google.com/")
webElem <- remDr$findElement(using = "css","[name='q']")
webElem$sendKeysToElement(list("JAVA",key="enter"))

#네이버 검색
remDr$navigate("http://naver.com/")
webElem <- remDr$findElement(using = "css","[id='query']")
webElem$sendKeysToElement(list("코로나",key="enter"))



# [ 네이버 웹툰 댓글 읽기 ]
url<-'http://comic.naver.com/comment/comment.nhn?titleId=570503&no=135'
remDr$navigate(url)

#단수형으로 노드 추출
more<-remDr$findElement(using='css','#cbox_module > div > div.u_cbox_sort > div.u_cbox_sort_option > div > ul > li:nth-child(2) > a')
more$getElementTagName()
more$getElementText()
more$clickElement()

# 2페이지부터 10페이지까지 링크 클릭하여 페이지 이동하기 
for (i in 4:12) {
  nextCss <- paste0("#cbox_module>div>div.u_cbox_paginate>div> a:nth-child(",i,") > span")
  nextPage<-remDr$findElement(using='css',nextCss)
  nextPage$clickElement()
  Sys.sleep(2)
}

#cbox_module > div > div.u_cbox_paginate > div > a:nth-child(4)
#cbox_module > div > div.u_cbox_paginate > div > a:nth-child(12)

#복수형으로 노드 추출 
url<-'http://comic.naver.com/comment/comment.nhn?titleId=570503&no=135'
remDr$navigate(url)
#베스트 댓글 내용 읽어오기
bestReviewNodes<-remDr$findElements(using ="css selector","ul.u_cbox_list span.u_cbox_contents")
sapply(bestReviewNodes,function(x){x$getElementText()})

#전체 댓글 링크 클릭후에 첫 페이지 내용 읽어오기
totalReview <- remDr$findElement(using='css','#cbox_module > div > div.u_cbox_sort > div.u_cbox_sort_option > div > ul > li:nth-child(2) > a')
totalReview$clickElement()
totalReviewNodes<-remDr$findElements(using ="css selector","ul.u_cbox_list span.u_cbox_contents")
sapply(totalReviewNodes,function(x){x$getElementText()})
