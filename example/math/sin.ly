package "trigonometric"

func sin(x) {
    var upper = 50, i = 0, sum = 0, sign = true
    while i < upper {
        if sign {
            sum = sum + power(x, 1 + 2 * i) / factorial(1 + 2 * i)
        } else {
            sum = sum - power(x, 1 + 2 * i) / factorial(1 + 2 * i)
        }
        sign = !sign
        i = i + 1
    }
    return sum
}