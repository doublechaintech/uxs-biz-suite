

import React, { Component } from 'react'
import FontAwesome from 'react-fontawesome';
import { connect } from 'dva'
import moment from 'moment'
import BooleanOption from 'components/BooleanOption';
import { Row, Col, Icon, Card, Tabs, Table, Radio, DatePicker, Tooltip, Menu, Dropdown,Badge, Switch,Select,Form,AutoComplete,Modal } from 'antd'
import { Link, Route, Redirect} from 'dva/router'
import numeral from 'numeral'
import {
  ChartCard, yuan, MiniArea, MiniBar, MiniProgress, Field, Bar, Pie, TimelineChart,
} from '../../components/Charts'
import Trend from '../../components/Trend'
import NumberInfo from '../../components/NumberInfo'
import { getTimeDistance } from '../../utils/utils'
import PageHeaderLayout from '../../layouts/PageHeaderLayout'
import styles from './EditorPickProduct.dashboard.less'
import DescriptionList from '../../components/DescriptionList';
import ImagePreview from '../../components/ImagePreview';
import GlobalComponents from '../../custcomponents';
import DashboardTool from '../../common/Dashboard.tool'
import appLocaleName from '../../common/Locale.tool'

const {aggregateDataset,calcKey, defaultHideCloseTrans,
  defaultImageListOf,defaultSettingListOf,defaultBuildTransferModal,
  defaultExecuteTrans,defaultHandleTransferSearch,defaultShowTransferModel,
  defaultRenderExtraHeader,
  defaultSubListsOf,
  defaultRenderExtraFooter,renderForTimeLine,renderForNumbers
}= DashboardTool



const { Description } = DescriptionList;
const { TabPane } = Tabs
const { RangePicker } = DatePicker
const { Option } = Select


const imageList =(editorPickProduct)=>{return [
	   {"title":'Product Cover Image',"imageLocation":editorPickProduct.productCoverImage},
]}

const internalImageListOf = (editorPickProduct) =>defaultImageListOf(editorPickProduct,imageList)

const optionList =(editorPickProduct)=>{return [ 
	]}

const buildTransferModal = defaultBuildTransferModal
const showTransferModel = defaultShowTransferModel
const internalSettingListOf = (editorPickProduct) =>defaultSettingListOf(editorPickProduct, optionList)
const internalLargeTextOf = (editorPickProduct) =>{

	return(<div> 
   <Card title={`Remark`} ><pre>{editorPickProduct.remark}</pre></Card>
</div>)

	

}


const internalRenderExtraHeader = defaultRenderExtraHeader

const internalRenderExtraFooter = defaultRenderExtraFooter
const internalSubListsOf = defaultSubListsOf


const internalRenderTitle = (cardsData,targetComponent) =>{
  
  
  const linkComp=cardsData.returnURL?<Link to={cardsData.returnURL}> <FontAwesome name="arrow-left"  /> </Link>:null
  return (<div>{linkComp}{cardsData.cardsName}: {cardsData.displayName}</div>)

}


const internalSummaryOf = (editorPickProduct,targetComponent) =>{
	
	
	const {EditorPickProductService} = GlobalComponents
	const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="Id">{editorPickProduct.id}</Description> 
<Description term="Name">{editorPickProduct.name}</Description> 
<Description term="Parent Category">{editorPickProduct.parentCategory==null?appLocaleName(userContext,"NotAssigned"):editorPickProduct.parentCategory.displayName}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"Parent Category","levelNCategory",EditorPickProductService.requestCandidateParentCategory,
	      EditorPickProductService.transferToAnotherParentCategory,"anotherParentCategoryId",editorPickProduct.parentCategory?editorPickProduct.parentCategory.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
<Description term="Brand">{editorPickProduct.brand==null?appLocaleName(userContext,"NotAssigned"):editorPickProduct.brand.displayName}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"Brand","brand",EditorPickProductService.requestCandidateBrand,
	      EditorPickProductService.transferToAnotherBrand,"anotherBrandId",editorPickProduct.brand?editorPickProduct.brand.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
<Description term="Origin">{editorPickProduct.origin}</Description> 
<Description term="Catalog">{editorPickProduct.catalog==null?appLocaleName(userContext,"NotAssigned"):editorPickProduct.catalog.displayName}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"Catalog","catalog",EditorPickProductService.requestCandidateCatalog,
	      EditorPickProductService.transferToAnotherCatalog,"anotherCatalogId",editorPickProduct.catalog?editorPickProduct.catalog.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
<Description term="Profile">{editorPickProduct.profile==null?appLocaleName(userContext,"NotAssigned"):editorPickProduct.profile.displayName}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"Profile","profile",EditorPickProductService.requestCandidateProfile,
	      EditorPickProductService.transferToAnotherProfile,"anotherProfileId",editorPickProduct.profile?editorPickProduct.profile.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
<Description term="Last Update Time">{ moment(editorPickProduct.lastUpdateTime).format('YYYY-MM-DD')}</Description> 
	
        {buildTransferModal(editorPickProduct,targetComponent)}
      </DescriptionList>
	)

}


class EditorPickProductDashboard extends Component {

 state = {
    transferModalVisiable: false,
    candidateReferenceList: {},
    candidateServiceName:"",
    candidateObjectType:"city",
    targetLocalName:"",
    transferServiceName:"",
    currentValue:"",
    transferTargetParameterName:"",  
    defaultType: 'editorPickProduct'


  }
  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const { id,displayName,  } = this.props.editorPickProduct
    if(!this.props.editorPickProduct.class){
      return null
    }
    const returnURL = this.props.returnURL
    
    const cardsData = {cardsName:"Editor Pick Product",cardsFor: "editorPickProduct",
    	cardsSource: this.props.editorPickProduct,returnURL,displayName,
  		subItems: [
    
      	],
  	};
    
    const renderExtraHeader = this.props.renderExtraHeader || internalRenderExtraHeader
    const settingListOf = this.props.settingListOf || internalSettingListOf
    const imageListOf = this.props.imageListOf || internalImageListOf
    const subListsOf = this.props.subListsOf || internalSubListsOf
    const largeTextOf = this.props.largeTextOf ||internalLargeTextOf
    const summaryOf = this.props.summaryOf || internalSummaryOf
    const renderTitle = this.props.renderTitle || internalRenderTitle
    const renderExtraFooter = this.props.renderExtraFooter || internalRenderExtraFooter
    return (

      <PageHeaderLayout
        title={renderTitle(cardsData,this)}
        content={summaryOf(cardsData.cardsSource,this)}
        wrapperClassName={styles.advancedForm}
      >
      {renderExtraHeader(cardsData.cardsSource)}
        <div>
        {settingListOf(cardsData.cardsSource)}
        {imageListOf(cardsData.cardsSource)}
        {subListsOf(cardsData)} 
        {largeTextOf(cardsData.cardsSource)}
          
        </div>
      </PageHeaderLayout>
    )
  }
}

export default connect(state => ({
  editorPickProduct: state._editorPickProduct,
  returnURL: state.breadcrumb.returnURL,
  
}))(Form.create()(EditorPickProductDashboard))

