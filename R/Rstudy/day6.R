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
