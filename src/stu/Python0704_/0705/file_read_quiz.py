'''
* points.txt 파일의 숫자값을 모두 읽어서
총합과 평균을 구한 뒤
총점, 평균값을 result.txt라는 파일에
쓰는 프로그램을 작성해 보세요.
'''

import traceback as trace


file_path='C:/Users/kyungmin/java_web_vs/python/test/points.txt'

try:
    f=open(file_path,'r')
    text=f.readline().split()

    total=0
    avg=0
    for n in text:
        total+=int(n)
        
    avg=total/len(text)
    
    file_path2='C:/Users/kyungmin/java_web_vs/python/test/result.txt'
    g=open(file_path2,'a')
    g.write(f'총점 {total} ,평균은 {avg:0.2f}')

    print('result.txt 파일 생성 성공')

except:
    print('실패')
    print(trace.format_exc()) # 자바의 printStackTrace() 와 동일한 기능 
finally:
    f.close()
    #g.close()
'''

try:
    f = open('C:/Users/user/Desktop/java_web_LKM/python/test/points.txt', 'r')
    numlist = f.read().split()
except:
    print('파일 로드 실패!')
    print(trace.format_exc()) # 자바의 printStackTrace
finally:
    f.close()

sum = 0
for num in numlist:
    score = int(num)
    sum += score

avg = sum / len(numlist)

try:
    f = open('C:/Users/user/Desktop/java_web_LKM/python/test/result.txt', 'w')
    data = f'총점: {sum}점, 평균: {avg:0.2f}점'
    f.write(data)
    print('파일 저장이 완료되었습니다.')
except:
    print('파일 저장 실패!')
finally:
    f.close()

'''