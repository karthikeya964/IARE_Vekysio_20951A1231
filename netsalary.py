t=int(input("Enter the annual income:"))
x=float(input())
y= float(input())
z=float(input())
n=int(input("enter no of weeks:"))
net_salary=n*t*(1-((x+y+z)/100))
print("%.2f"%net_salary)


