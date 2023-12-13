package resources

class Strings {
    companion object {
        const val GREETING = "========== 호텔 예약 프로그램입니다. =========="
        const val CHOOSE_OPTIONS =
            "[메뉴]\n[1] 방 예약, [2] 예약목록 출력, [3] 예약목룍 (정렬) 출력, [4] 시스템 종료, [5] 금액 입금+출금 내역 목록 출력, [6] 예약 변경/취소"
        const val WRONG_OPTION = "잘못된 값을 입력하셨습니다. 다시 입력해주세요."

        const val GET_NAME = "예약자 분의 성함을 입력해주세요."

        const val GET_ROOM_NUMBER = "예약할 방 번호를 입력해주세요."
        const val WRONG_ROOM_NUMBER = "올바르지 않은 방번호입니다. 방번호는 100~999 영역 이내입니다."
        const val ROOM_UNAVAILABLE = "해당 날짜에 방을 이미 사용 중입니다. 다른 날짜를 입력해주세요."

        const val GET_CHECKIN_DATE = "체크인 날짜를 입력해주세요 (표기형식 : yyyymmdd)"
        const val WRONG_CHECKIN_DATE = "이미 지난 날은 체크인 날짜로 선택할 수 없습니다."
        const val GET_CHECKOUT_DATE = "체크아웃 날짜를 입력해주세요 (표기형식 : yyyymmdd)"
        const val WRONG_CHECKOUT_DATE = "체크아웃 날짜가 체크인 날짜와 같거나 이전일 수 없습니다"

        const val COMPLETE_RESERVATION = "호텔 예약이 완료되었습니다"

        const val RESERVATION_LIST = "호텔 예약자 목록입니다."
        const val RESERVATION_LIST_SORTED = "호텔 예약자 목록입니다. (정렬 기준 : 체크인 날짜)"

        const val QUIT_SYSTEM = "예약 시스템을 종료합니다. 이용해주셔서 감사합니다."

    }
}