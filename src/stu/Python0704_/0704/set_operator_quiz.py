
'''


서로 다른 정수가 담긴 두 개의 리스트를 비교하여

li안에 있는 정수가 li2에도 담겨 있다면 그 정수를 배제하시고
서로 겹치지 않는 정수만 담긴 새로운 리스트를 생성해 보세요 
'''

li=[1,2,3,4,5,6,7]
li2=[1,3,8,4,5,7,101]
c=set()

l=set(li)
l2=set(li2)

for x in l:
    if x not in l2:
        c.add(x)
    
for x in l2:
    if x not in l:
        c.add(x)

print(list(c)) 

result=set(li)^set(li2)
print(result)