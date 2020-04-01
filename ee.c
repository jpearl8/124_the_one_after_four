#include <float.h>
#include <math.h>
#include <stdbool.h>
#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <gmp.h>

long long* ee (long long a, long long b, long long* answer);

int main(int argc, char** argv) {
    if (argc != 3) {
        printf("Usage: ./ee a b \n");
        return 1;
    }
    char* ptr1;
    char* ptr2;
    long long a = strtoll(argv[1], &ptr1, 10);
    long long b = strtoll(argv[2], &ptr2, 10);
    
    long long *answer = (long long *)malloc(3 * sizeof(long long));
    answer = ee(a, b, answer);
    printf(" FINAL ANSWER: %lld\n", answer[2]);
    free(answer);
    return 0;
}

long long* ee (long long a, long long b, long long* answer){
    // printf("a: %d | b: %d |  \n", a, b);
    long long k;
    if (b == 0){
        answer[0] = a;
        answer[1] = 1;
        answer[2] = 0;
        // printf("k: DNE | x: %d | y: %d \n", answer[1], answer[2]);
        return answer;
    } else {
        k = (a - (a % b)) / b;
        answer = ee(b, a % b, answer);
        long long temp_x = answer[1];
        long long temp_y = answer[2];
        
        answer[1] = temp_y;
        answer[2] = temp_x - k*temp_y;
        // printf("k: %d | x: %d | y: %d \n", k, temp_x, temp_y);
        return answer;
    }
    // return answer;
}