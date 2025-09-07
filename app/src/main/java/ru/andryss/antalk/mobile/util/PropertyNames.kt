package ru.andryss.antalk.mobile.util

class PropertyNames {
    companion object {
        /**
         * Таймаут одного запроса в секундах
         */
        const val ANTALK_REQUEST_TIMEOUT = "antalk.client.request.timeout.seconds"

        /**
         * Таймаут ожидания создания соединения в секундах
         */
        const val ANTALK_CONNECT_TIMEOUT = "antalk.client.connect.timeout.seconds"

        /**
         * URL для
         */
        const val ANTALK_BASE_URL = "antalk.client.url"
    }
}
