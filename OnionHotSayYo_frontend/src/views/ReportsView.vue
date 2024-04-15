<template>
    <div class="reportsView">
      <div class="list-container">
        <div class="list-header">
          <h5 id="report-name"><b> 내 신고목록 </b></h5>
          <!-- <button type="button" class="btn btn-light" @click="goToWrite">글 작성</button> -->
        </div>
        <div id="table-container">
          <table class="table table-hover">
            <thead>
              <tr>
                <th class="REPORT_ID" scope="col">번호</th>
                <th class="TYPE" scope="col">신고 유형</th>
                <th class="DATE" scope="col">신고 일자</th>
                <th class="IS_PUNISHED" scope="col">처벌 여부</th>
                <th class="SUBSTANCE" scope="col">신고내용</th>
                <th class="REPORTED_ID" scope="col">피신고자ID</th>
              </tr>
            </thead>
            <tbody class="table-group-divider" v-if="reports.length">
              <tr v-for="report in pageReport" :key="report.REPORT_ID">
                <td class="REPORT_ID">{{ report.REPORT_ID }}</td>
                <td class="TYPE">{{ report.TYPE }}</td>
                <td class="DATE">{{ report.DATE }}</td>
                <td class="IS_PUNISHED">{{ getIsPunishedStatus(report.IS_PUNISHED) }}</td>
                <td class="SUBSTANCE">{{ report.SUBSTANCE }}</td>
                <td class="REPORTED_ID">{{ report.REPORTED_ID }}</td>
              </tr>
            </tbody>
          </table>
        </div>
      </div>
    </div>
  </template>
  
  <script setup>
  import { ref, watch, onMounted, computed } from 'vue';
  import axios from 'axios';
  
  const reports = ref([]);
  
  const pageReport = ref([]);
  const index = ref(0);
  const next = ref(10);
  
  watch(reports, () => {
    pageReport.value = reports.value.slice(index.value, next.value);
  });
  
  onMounted(async () => {
  try {
    const response = await axios.get('http://localhost:8084/reports?_sort=REPORT_ID');
    reports.value = response.data;
  } catch (error) {
    console.error("Error fetching reports:", error);
  }
});

const getIsPunishedStatus = (isPunished) => {
    return isPunished === 1 ? '조치 완료' : '조치 중';
};

  </script>

<style scoped>
.table th.IS_PUNISHED,
.table td.IS_PUNISHED {
    width: 10%; /* 적절한 너비로 조정하세요 */
}

.table th.TYPE,
.table td.TYPE {
    width: 10%; /* 적절한 너비로 조정하세요 */
}
</style>