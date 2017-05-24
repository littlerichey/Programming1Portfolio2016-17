
al = [1, 1.2, 1.375, 1.55, 1.725, 1.9]

def calcCalM(w, h, a, female, act, wc):
    if female:
        x = 10 * w + 6.25 * h - 5 * a - 161
    else:
        x = 10 * w + 6.25 * h - 5 * a + 5
    x *= al[act]
    x += wc * 1000
    return int(x)

def calcCalI(w, hf, hi, a, female, act, wc):
    w /= 2.20462
    h = ((hf * 12) + hi) * 2.54
    if female:
        x = 10 * w + 6.25 * h - 5 * a - 161
    else:
        x = 10 * w + 6.25 * h - 5 * a + 5
    x *= al[act]
    x += wc * 500
    return int(x)