<template>
  <div class="add-post">
    <form action="http://localhost:8081/post.json" method="POST">
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
        <Ckeditor :editor="editor" v-model="text" :config="editorConfig"></Ckeditor>
      </div>
      <br>
      <p><input type="submit" value="전송" @click="goPostList"></p>
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

const router = useRouter();


function goPostList() {
  router.push(`/list/1`); // 임시로 1로 설정


  let text = ref();

  const emits = defineEmits(['update:modelValue']);

  /**
   * v-model 값 연결
   */
  watch(text, (newValue, oldValue) => {
    emits('update:modelValue', newValue);
  });

  // import Upload Adapter


}
// Custom Upload Adapter Plugin function
function CustomUploadAdapterPlugin(editor) {
  editor.plugins.get('FileRepository').createUploadAdapter = (loader) => {
    // Create new object and pass server url
    return new UploadAdapter(loader, '');
  };
}
const editor = ClassicEditor;
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
      'blockQuote',
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

function uploadData() {
    const editorData = editor.getData();
    console.log('Editor Data:', editorData);
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

.registbutton {
  margin-left: 750px;
}
</style>
