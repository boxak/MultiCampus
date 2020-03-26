library(rvest)
page.getContent <- function(url,encoding = "UTF-8",css,xpath = NULL,trim = TRUE){
  webpage <- read_html(url,encoding = encoding)
  nodes <- html_nodes(webpage,css)
  texts <- html_text(nodes,trim = trim)
  return(texts)
}

page.getAttr <- function(url,encoding = "UTF-8",css,xpath = NULL){
  webpage <- read_html(url,encoding = encoding)
  nodes <- html_nodes(webpage,css)
  attrs <- html_attrs(nodes)
  return(attrs)
}