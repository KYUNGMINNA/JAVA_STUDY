
print('저장할 내용을 입력 (\'그만\' 이라고 입력시 종료됩니다.)')
c=''
while True:
    a=input('>')

    if a=='그만':
    
        break
    c+=a+'\n'

try:
    b=input('파일명을 입력:')
    file_path=r'C:\Users\kyungmin\java_web_vs\python\test/'+b+'.txt'


    f=open(file_path,'a')
    
    f.write(c)
    print('파일 저장 성공 !')

except:
    print('파일 저장 실패!')

finally:

    f.close()
