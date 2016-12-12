/*
groovy -e 'groovy script' : groovy script 실행
-n or -p : input stream 한줄씩 실행
-i : backup file pattern when saving the files
-l : groovy in listening mode. telnet client로 groovy 프로세스에 접속해서 명령을 수행할 수도 있음.
 */

$ groovy -e 'Locale.availableLocales.each {println it.displayName}' | grep 영어
영어 (미국)
영어 (싱가포르)
영어 (몰타)
영어
영어 (필리핀)
영어 (뉴질랜드)
영어 (남아프리카)
영어 (오스트레일리아)
영어 (아일랜드)
영어 (캐나다)
영어 (인도)
영어 (영국)

$ groovy -l 9000 -e "println 'you say : ' + line"
telnet 으로 한줄씩 입력하면 -e 옵션 뒤에 있는 명령에서 각 줄을 line 변수로 받아서 실행
