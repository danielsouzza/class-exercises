from time import sleep

def cpu():
    i = 0
    clock = 0
    while clock < 10:
        if(clock % 2 == 0): print(i+1)
        else :print(i)
        sleep(1)
        clock += 1
cpu()