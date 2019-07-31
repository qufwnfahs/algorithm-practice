class Student:
    # __init__
    # 초기화 메소드 (initialize)
    # 어떤 클래스의 객체가 만들어질 때 자동으로 호출되어서 그 객체가 갖게 될
    # 여러 가지 성질을 정해주는 일을 수행
    def __init__(self, name, grade, age) :
        self.name = name
        self.grade = grade
        self.age = age
    # __repr__
    # 프린팅 메소드 (representation)
    # 기본적인 print문을 사용할 때 출력시킬 내용을 정의한다
    def __repr__(self) :
        return repr((self.name, self.grade, self.age))
    #__add__
    # 덧셈 메소드
    def __add__(self, other) :
        return self.age + other.age

    # 모든 비교 연산자에 대해 실제로 동작을 구현
    # 원하는 대로 수행되지 못할 수 있다.
    def __cmp__(self, other) :
        if self.age < other.age :
            return -1
        elif self.age == other.age :
            return 0
        else :
            return 1
    # 보다 큼 연산자, > 에 대한 동작을 정의
    def __gt__(self, other) :
        return self.age > other.age
    # 보다 작음 연산자, < 에 대한 동작을 정의
    def __lt__(self, other) :
        return self.age < other.age
    # 크거나 같음 연산자, >= 에 대한 동작을 정의
    def __ge__(self, other) :
        return self.age >= other.age
    # 보다 작거나 같음 연산자, <= 에 대한 동작을 정의
    def __le__(self, other) :
        return self.age <= other.age

student_objects = [
    Student('john', 'A', 15),
    Student('jane', 'B', 12),
    Student('dave', 'C', 10)
]

# output [('john', 'A', 15), ('jane', 'B', 12), ('dave', 'C', 10)]
print(student_objects)

# output 27
print(student_objects[0] + student_objects[1])

# output True
print(student_objects[0] > student_objects[1])
