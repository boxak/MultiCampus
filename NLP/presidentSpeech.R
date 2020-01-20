# 환경설정
library('tidyverse')
library('rvest')
library('stringr')
library('RmecabKo')
library('tidytext')

# R환경의 OS 구하기

get_os <- function(){
  
  sysinf <- Sys.info()
  if(!is.null(sysinf)){
    os <- sysinf['sysname']
    if(os == 'Darwin'){
      os <- "osx"
    }
  }
  else{
    os <- .Platform$OS.type
    if(grepl("^darwin",R.versin$os)){
      is <- "osx"
    }
    if(grepl("linux-gnu",R.version$os)){
      is <- "linux"
    }
  }
  tolower(os)
}