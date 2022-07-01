

'''

문자열 알파벳 형태 변경 메서드 

1. lower() : 영문 알파벳 모두 소문자로 변경
2. upper()  : 영문 알파벳을 모두 대문자로 변경

3.swapcase() : 영문 대소문자를 각각 반대로 변경
4.captalize() : 문장의 맨 첫 글자만 대문자, 나머지 솜누자
5. title()  : 각 단어의 맨 첫글자만 대문자, 나머지 소문자( 단어의 기준은 공백으로  공백 이후 단어의 첫글자)
'''

s='GOOD MORning!!! my nams is LEE'

print(s)
print(s.lower())
print(s.upper())
print(s.swapcase())
print(s.capitalize())
print(s.title())