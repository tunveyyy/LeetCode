Approaches for Problems:
1. Dynamic Programming approaches for array
    * Linear approach - LeetCode 239
    `Algorithm

    The algorithm is quite straightforward :
    1. Iterate along the array in the direction left->right and build an array left.

    2. Iterate along the array in the direction right->left and build an array right.

    3. Build an output array as max(right[i], left[i + k - 1]) for i in range (0, n - k + 1).' `