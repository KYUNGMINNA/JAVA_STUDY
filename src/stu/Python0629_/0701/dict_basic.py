
'''
사전(Dictionary)

-사전은 키(key)와 값(value)의 쌍을 저장하는 대용량의 자료구조
-사전은 타 언어에서는 Map이라고 부르며 연관배열이라고도 부른다.

사전을 정의하는 기호는 {} 이고 , 괄호 안에 데이터를 
key : value 의 형태로 나열하여 저장

'''
students={'멍멍이':'김철수','야옹이':'박영희','쨱짹이':'홍길동'}
print(type(students))
print(len(students))

'''
사전에 사용되는 key값은 중복값을 가질 수 없고 , 변경도 안됩니다. :변경하려면 기존의 키를 삭제하고 ,새롭게 넣어야한다
-반면에 value값은 중복 허용,데이터 자유롭게 편집 가능 

사전 내부에 저장된 데이터를 검색할 대는 인덱스 대신 key를 사용합니다(시퀀스 자료형이 아님)
'''

print(students['멍멍이'])
print(students['쨱짹이'])
#print(students['메뚜기']) XXX   오류 발생하기 때문에 , 키 존재 유무부터 확인

#in 키워드를 사용하여 key존재 유무를 파악 할 수 있습니다.
print('멍멍이' in students)
print('메뚜기' in students)
