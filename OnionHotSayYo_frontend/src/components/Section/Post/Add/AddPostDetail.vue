<template>
  <div class="add-post">
    <div class="seeking-post-header">
      <div class="seeking-header">
        <div class="text-wrapper"> 게시글 작성</div>
        <div style="width: 100%">
          <input type="text" class="form-control" id="add-post-title"
              placeholder="제목을 입력하세요">
      </div>
      </div>
      <!-- <b></b> -->
    </div>
    <div class="content-wrapper">
      <div class="group-4">
        <div class="overlap-group-4">
          <textarea placeholder="내용을 작성하세요" class="text-wrapper-5" v-model="content"></textarea>
        </div>
      </div>
    </div>
          <button class="registbutton" @click="goPostList">등록</button>
    </div>
</template>
  
  <script setup>

  // import { defineEmits, ref } from 'vue';
  import { useRouter } from "vue-router";
  // import axios from 'axios';
  
  const router = useRouter();
  
  // /* 제목 */
  // const title = ref('');
  
  // /* 태그 */
  // const tags = ref([
  //   { name: 'Spring', isSelected: false },
  //   { name: 'Vue', isSelected: false },
  //   { name: 'Java', isSelected: false },
  //   { name: 'React', isSelected: false },
  //   { name: 'JavaScript', isSelected: false },
  //   { name: 'mariaDB', isSelected: false },
  //   { name: 'Oracle', isSelected: false },
  // ]);
  // const selectedTags = ref([]);
  
  // function toggleTag(tagName) {
  //   for (let i = 0; i < tags.value.length; i++) {
  //     if (tags.value[i].name == tagName) {
  //       tags.value[i].isSelected = !tags.value[i].isSelected;
  //       if (tags.value[i].isSelected) {
  //         selectedTags.value.push(tags.value[i].name);
  //       } else {
  //         for (let j = 0; j < selectedTags.value.length; j++) {
  //           if (selectedTags.value[i] === tagName) {
  //             selectedTags.value.splice(i, 1);
  //           }
  //         }
  //       }
  //     }
  //   }
  // }
  
  // /* 내용 */
  // const content = ref('');
  
  // /* 등록 버튼 */
  // const fontColor = ref('#ffffff');
  // function mouseoverHandler() {
  //   fontColor.value = '#000000';
  // }
  
  // function mouseoutHandler() {
  //   fontColor.value = '#ffffff';
  // }
  
  
  // /* POST 요청 */
  // const emit = defineEmits(['newPost']);
  
  // const addPost = ref({});
  
  // async function addNewPost() {
  //   let techStackStrings = selectedTags.value.join(', ');
  //   const responseDetail = await axios.get("http://localhost:8080/seekingPostDetail?_sort=-ID&_limit=1");
  //   let detailPostId = responseDetail.data[0].ID;
  
  //   const responseList = await axios.get("http://localhost:8081/seekingPostList?_sort=-SEEKING_MEMBER_POST_ID&_limit=1");
  //   let listPostId = responseList.data[0].SEEKING_MEMBER_POST_ID;
  
  //   addPost.value = {
  //     SEEKING_MEMBER_POST_ID: listPostId + 1,
  //     IS_BOOKMARK: 0,
  //     ID: detailPostId + 1,
  //     TITLE: title.value,
  //     CONTENT: content.value,
  //     TECH_STACK: techStackStrings,
  //     IS_SEEKING: isSeeking.value,
  //     NICKNAME: "오모기",
  //     LAST_MODIFIED_DATE: todayFormatted
  //   };
  
  //   emit('newPost', addPost);
  // }
  function goPostList() {
    // router.push(`/list/${ categoryId }`);
    router.push(`/list/1`)
  }
  
  </script>
  
  <style scoped>  

  .registbutton {
    width: 70px;
    display:inline-flex;
    justify-content: center;
    margin-top: 20px; /* 등록 버튼과의 간격 조절 */
    border: 1px solid;
  }

  .content-wrapper {
    width: 100%;
    margin-top: 20px; /* 내용 입력 블록과의 간격 조절 */
  }

  .seeking-post-header {
     display: flex;
     justify-content: space-between;
     align-items: center;
     padding: 10px;
     background-color: white;
  }
  
  .add-post {
    display: flex;
    flex-direction: column;
    align-items: center;
    padding: 0 20px; /* 여백을 같게 조절 */
  }
  
  .group-4 {
    position: relative;
    width: 961px;
    height: 838px;
    margin-right: -2px;
    border: 1px solid;
    border-color: #acacac;
    background-color: white;
  }
  
  
  
  .text-wrapper-5 {
    position: absolute;
    width: 300px;
    top: 23px;
    left: 16px;
    font-family: "Outfit", Helvetica;
    font-weight: 400;
    font-size: 20px;
    letter-spacing: 0;
    line-height: normal;
    width: 920px;
    height: 790px;
    border: none;
    color: black;
    resize: none;
  }
  
  .button {
    position: relative;
    width: fit-content;
    height: fit-content;
  }
  
  
  .overlap-group-5 {
    position: relative;
    width: 236px;
    height: 65px;
    background-image: url(@/assets//img/rectangle-4248.svg);
    background-size: 100% 100%;
    cursor: pointer;
    background-color: white;
  }
  
  .text-wrapper-6 {
    position: absolute;
    width: fit-content;
    top: 16px;
    left: 94px;
    font-family: "Outfit", Helvetica;
    font-weight: 400;
    color: #000000;
    font-size: 24px;
    letter-spacing: 0;
    line-height: normal;
    cursor: pointer;
  }
  
  
  .seeking-post-header {
    align-items: center;
    display: inline-flex;
    widows: fit-content;
    flex: 0 0 auto;
    flex-direction: column;
    gap: 25px;
    position: relative;
  }
  
  .seeking-post-header .seeking-header {
    align-items: flex-start;
    display: inline-flex;
    flex: 0 0 auto;
    flex-direction: column;
    gap: 33px;
    position: relative;
  }
  
  .seeking-post-header .text-wrapper {
    color: #000000;
    font-family: "Outfit", Helvetica;
    font-size: 24px;
    font-weight: 400;
    letter-spacing: 0;
    line-height: normal;
    margin-top: -1px;
    position: relative;
    width: fit-content;
  }
    
  .seeking-post-header .overlap-group {
    background-color: #ffffff;
    border: 1px solid;
    border-color: #a09f9f;
    height: 51px;
    position: relative;
    width: 961px;
  }
  
  .seeking-post-header .div {
    color: #000000;
    font-family: "Outfit", Helvetica;
    font-size: 24px;
    font-weight: 400;
    left: 11px;
    letter-spacing: 0;
    line-height: normal;
    position: absolute;
    top: 8px;
    white-space: nowrap;
    width: 930px;
    height: 32px;
    border-width: 0px;
    resize: none;
  }
  </style>
  