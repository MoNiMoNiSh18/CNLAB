#include <stdio.h>

int main() {
    int i, f, w, frames[50];

    printf("Enter window size: ");
    scanf("%d", &w);

    printf("Enter number of frames: ");
    scanf("%d", &f);

    printf("Enter frames: ");
    for (i = 1; i <= f; i++) {
        scanf("%d", &frames[i]);
    }

    printf("\nSliding Window Protocol Processing...\n");

    printf("\nThe %d frames are sent to receiver\n", w);

    for (i = 1; i <= f; i++) {
        printf("%d ", frames[i]);

        if (i % w == 0) {
            printf("\nAcknowledgement received for above frames\n");
        }
    }

    if ((i - 1) % w != 0) {
        printf("\nAcknowledgement received for remaining frames\n");
    }

    return 0;
}
