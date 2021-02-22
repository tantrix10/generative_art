import numpy as np
import matplotlib.pyplot as plt


density = 250
thresh = 0.4
limit = 200
x =np.linspace(-2.5,1,density)
y =np.linspace(-2,2,density)

def man(z, c=0):
    return z*z+c
#z = np.array([i*i+j*j for i in x for j in y])
#Z = z.reshape(21,21)
Z = np.empty([density, density])

for i in range(density):
    for j in range(density):
        count = 0
        z = 0+0*1j
        cr = x[i]
        ci = y[j]
        for k in range(limit):
            count+=1
            z = man(z, c = (cr+ci*1j))
            if np.abs(z) > thresh:
                Z[j,i] = count
                continue
        #print(np.abs(z))
        #Z[i,j] = count

plt.imshow(Z,interpolation='bilinear')
plt.show()
