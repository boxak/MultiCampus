library(rvest)
setwd("function")
getwd()
source("crawler.R",encoding = "UTF-8")
url <- "http://unico2013.dothome.co.kr/crawling/exercise_bs.html"

# h1 태그 컨텐츠 가져오기
h1.nodes <- html_nodes(webpage,"h1")
h1.nodes
h1.texts <- html_text(h1.nodes,trim = TRUE)

#a 태그 컨텐츠와 href 속성값 가져오기
a.nodes <- html_nodes(webpage,"a")
a.nodes
a.attrs <- html_attrs(a.nodes)
a.attrs
a.texts <- html_text(a.nodes,trim = TRUE)
a.texts <- a.texts[!(is.na(a.texts) | a.texts=="")]

# img의 src 속성값 가져오기
img.attrs <- page.getAttr(url,encoding,"img")
img.attrs

#첫번째 h2태그의 컨텐츠 가져오기
css = "h2:nth-of-type(1)"
h2.first.texts <- page.getContent(url,trim = TRUE,css = css)
h2.first.texts

#<ul> 태그의 자식 태그 중 style 속성값이 green으로 끝나는 태그의 컨텐츠
css = 'ul > *[style$="green"]'
ul.green.texts <- page.getContent(url,css = css,trim = TRUE)

#두번째 h2 태그의 컨텐츠
css = "h2:nth-of-type(2)"
h2.second.texts <- page.getContent(url,css = css)

#ul태그의 모든 자식 태그들의 컨텐츠
css = "ol > *"
ul.all.texts <- page.getContent(url,css = css)

#table 태그 모든 자손 태그 컨텐츠
css = "table *"
table.all.texts <- page.getContent(url,css = css)

#클래스가 name인 tr 태그의 컨텐츠
css = "tr.name"
tr.name.texts <- page.getContent(url,css = css)

#아이디가 target인 td 태그의 컨텐츠
css ="td#target"
td.target.texts <- page.getContent(url,css = css)