<template>
    <div id="section-container">
        <h5 id="category-name">카테고리 이름</h5>
        <hr>
        <div id="table-container">
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th class="col-number" scope="col">번호</th>
                        <th class="col-title" scope="col">제목</th>
                        <th class="col-writer" scope="col">글쓴이</th>
                        <th class="col-hits" scope="col">조회</th>
                        <th class="col-like" scope="col">좋아요</th>
                        <th class="col-dislike" scope="col">싫어요</th>
                        <th class="col-date" scope="col">날짜</th>
                    </tr>
                </thead>
                <tbody class="table-group-divider">
                    <tr>
                        <td class="col-number" scope="row">1</td>
                        <td class="col-title">단기 알바 구해요</td>
                        <td class="col-writer">고로상</td>
                        <td class="col-hits">55</td>
                        <td class="col-like">0</td>
                        <td class="col-dislike">0</td>
                        <td class="col-date">23-01-22</td>
                    </tr>
                </tbody>
            </table>
        </div>
        <div id="pagenation-container">
            <ul class="pagination">
                <li class="page-item">
                    <a class="page-link" href="#" aria-label="Previous">
                        <span aria-hidden="true">&laquo;</span>
                    </a>
                </li>
                <li class="page-item"><a class="page-link" href="#">1</a></li>
                <li class="page-item"><a class="page-link" href="#">2</a></li>
                <li class="page-item"><a class="page-link" href="#">3</a></li>
                <li class="page-item">
                    <a class="page-link" href="#" aria-label="Next">
                        <span aria-hidden="true">&raquo;</span>
                    </a>
                </li>
            </ul>
        </div>
    </div>
</template>

<script setup>

</script>

<style scoped>
#section-container {
    display: block;
    unicode-bidi: isolate;
    width: 100%;
    height: 100%;
}

#category-name {
    font-size: 25px;
    font-weight: bold;
    margin-left: 15px;
}

#table-container {
    display: flex;
    justify-content: center;
}

#pagenation-container {
    display: flex;
    justify-content: center;
}

.col-number {
    width: 5%;
    text-align: center;
}

.col-title {
    width: 20%;
    text-align: center;
}

.col-writer {
    width: 10%;
    text-align: center;
}

.col-hits {
    width: 10%;
    text-align: center;
}

.col-like {
    width: 10%;
    text-align: center;
}

.col-dislike {
    width: 10%;
    text-align: center;
}

.col-date {
    width: 15%;
    text-align: center;
}
</style>
