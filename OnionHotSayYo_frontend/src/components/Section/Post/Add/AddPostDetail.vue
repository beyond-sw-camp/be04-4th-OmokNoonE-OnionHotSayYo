<template>
  <div class="add-post">
    <form method="POST" @submit.prevent="uploadData">
      <div class="seeking-post-header">
        <div class="seeking-header">
          <div class="text-wrapper">게시글 작성</div>
          <div style="width: 100%">
            <input type="text" class="form-control" id="add-post-title" placeholder="제목을 입력하세요">
          </div>
        </div>
      </div>
      <br>
      <div id="app">
        <Ckeditor :editor="editor" v-model="editorData" :config="editorConfig"></Ckeditor>
      </div>
      <br>
      <p><input type="submit" value="전송"></p>
    </form>
  </div>
</template>

<script setup>
import { useRouter } from "vue-router";
import { ClassicEditor } from '@ckeditor/ckeditor5-editor-classic';
import { Essentials } from '@ckeditor/ckeditor5-essentials';
import { Bold, Italic } from '@ckeditor/ckeditor5-basic-styles';
import { BlockQuote } from '@ckeditor/ckeditor5-block-quote';
import { Link } from '@ckeditor/ckeditor5-link';
import { Paragraph } from '@ckeditor/ckeditor5-paragraph';
import { Indent } from '@ckeditor/ckeditor5-indent';
import { List } from '@ckeditor/ckeditor5-list';
import { MediaEmbed } from '@ckeditor/ckeditor5-media-embed';
import { Table, TableColumnResize, TableToolbar } from '@ckeditor/ckeditor5-table';
import { TextTransformation } from '@ckeditor/ckeditor5-typing';
import { Alignment } from '@ckeditor/ckeditor5-alignment';
import { Image, ImageCaption, ImageStyle, ImageToolbar, ImageUpload, ImageResize } from '@ckeditor/ckeditor5-image';

import { ref, watch } from 'vue';
import UploadAdapter from '@/UploadAdapter';
import axios from "axios";
import { onMounted } from "vue";

const router = useRouter();


let text = ref('');
const title = ref('');
const editor = ClassicEditor;
const editorData = ref('');

const emits = defineEmits(['update:modelValue']);

/**
 * v-model 값 연결
 */
watch(editorData, (newValue, oldValue) => {
  emits('update:modelValue', newValue);
  console.log('내용', newValue);
});

// import Upload Adapter


// 이미지 업로드 어댑터 정의
function CustomUploadAdapterPlugin(editor) {
  editor.plugins.get('FileRepository').createUploadAdapter = (loader) => {
    // Create new object and pass server url
    return new UploadAdapter(loader, '');
  };
}

// const editor = ClassicEditor;
const editorConfig = {
  extraPlugins: [CustomUploadAdapterPlugin],
  plugins: [
    Essentials,
    Bold,
    Italic,
    Link,
    Paragraph,
    BlockQuote,
    Indent,
    List,
    Table,
    TableToolbar,
    TableColumnResize,
    TextTransformation,
    Alignment,
    Image,
    ImageCaption,
    ImageStyle,
    ImageToolbar,
    ImageUpload,
    ImageResize,
    MediaEmbed,
  ],
  toolbar: {
    items: [
      'bold',
      'italic',
      'link',
      'imageUpload',
      'indent',
      'outdent',
      'numberedList',
      'bulletedList',
      'alignment',
      'mediaEmbed',
      'undo',
      'redo',
      'insertTable',
    ],
  },
  image: {
    toolbar: [
      'imageTextAlternative',
      'toggleImageCaption',
      'imageStyle:inline',
      'imageStyle:block',
      'imageStyle:side',
    ],
  },
  table: {
    contentToolbar: ['tableColumn', 'tableRow', 'mergeTableCells', 'tableProperties', 'tableCellProperties'],
  },
};


async function uploadData() {
  console.log(editorData.value);
  try {
    // const editorData = editor.getData; 
        // console.log('editorData', editorData);
    title.value = document.getElementById('add-post-title').value;

    // 만약 사용자가 제목을 입력하지 않았다면 오류 메시지 출력 후 함수 종료
    if (!title.value.trim()) {
      console.error('제목을 입력하세요.');
      return;
    }

    console.log('제목', title.value);
    console.log('내용', editorData.value);

    // FormData 객체 생성
    const formData = new FormData();
    formData.append('title', title.value);
    formData.append('content', editorData.value);
    formData.append('categoryId', 1);
    formData.append('image',  CustomUploadAdapterPlugin.value);
    formData.append('locationId', 31);

    console.log(formData.toString());
    // axios를 사용하여 서버로 데이터를 전송
    const response = await axios.post('http://localhost:8080/posts/create', formData);

    console.log('서버:', response.data);

    goPostList();

  } catch (error) {
    console.error('데이터 업로드 중 오류 발생:', error);
  }
}


function goPostList() {
  router.push(`/list/1`); // 임시로 1로 설정
}
</script>

<style>
.ck.ck-editor {
  width: 800px;
  margin: 0 auto;
}

.ck-editor__editable {
  min-height: 450px !important;
  max-height: 800px !important;
}


</style>
