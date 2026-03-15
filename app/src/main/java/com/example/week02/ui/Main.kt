package com.example.week02.ui


import com.example.week02.service.TaskService
import com.example.week02.util.readInt
import com.example.week02.util.readString

fun main() {
    val service = TaskService()


    while (true) {
        println("\n--- [건국대] Smart Manager ---")
        println("1.추가  2.목록  3.검색  4.토글  5.삭제  6.종료")


        val menu = readInt("메뉴 선택: ")

        when (menu) {
            1 -> {
                val type = readString("타입(TASK/NOTE): ")
                val title = readString("제목: ")
                val priority = readString("우선순위(P1~P3): ")
                service.addItem(type, title, priority)
                println("=> 추가 완료!")
            }
            2 -> {
                val list = service.getItems()
                if (list.isEmpty()) {
                    println("(!) 등록된 데이터가 없습니다.")
                } else {
                    println("\n[목록 조회]")
                    list.forEach { println("ID:${it.id} [${it.type}] ${it.title} (완료:${it.isDone}) - ${it.priority}") }
                }
            }
            3 -> {
                val key = readString("검색어 입력: ")
                val results = service.searchItems(key)
                if (results.isEmpty()) println("(!) 검색 결과가 없습니다.")
                results.forEach { println("ID:${it.id} ${it.title}") }
            }
            4 -> {
                val id = readInt("완료 토글할 ID: ")
                if (service.toggleDone(id)) println("=> 상태가 변경되었습니다.")
                else println("(!) 해당 ID를 찾을 수 없습니다.")
            }
            5 -> {
                val id = readInt("삭제할 ID: ")
                if (service.deleteItem(id)) println("=> 삭제되었습니다.")
                else println("(!) 해당 ID를 찾을 수 없습니다.")
            }
            6 -> {
                println("프로그램을 종료합니다. 수고하셨습니다!")
                break
            }
            else -> {
                println("(!) 1~6 사이의 숫자를 입력해주세요.")
            }
        }
    }
}