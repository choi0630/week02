package com.example.week02.util

fun readInt(prompt: String): Int {
    while (true) { // 👈 숫자를 제대로 넣을 때까지 무한 반복
        print(prompt) // println 대신 print를 쓰면 입력창이 같은 줄에 생겨 더 깔끔합니다.
        val input = readlnOrNull()?.toIntOrNull()

        if (input != null) {
            return input // 👈 정상적인 숫자면 즉시 반환하고 함수 종료
        } else {
            println("[오류] 숫자만 입력 가능합니다. 다시 시도해주세요.")
        }
    }
}

fun readString(prompt: String): String {
    print(prompt)
    return readlnOrNull() ?: ""
}