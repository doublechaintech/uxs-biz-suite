

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
import styles from './Review.dashboard.less'
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


const imageList =(review)=>{return [
	 ]}

const internalImageListOf = (review) =>defaultImageListOf(review,imageList)

const optionList =(review)=>{return [ 
	]}

const buildTransferModal = defaultBuildTransferModal
const showTransferModel = defaultShowTransferModel
const internalSettingListOf = (review) =>defaultSettingListOf(review, optionList)
const internalLargeTextOf = (review) =>{

	return(<div> 
   <Card title={`Content`} ><pre>{review.content}</pre></Card>
</div>)

	

}


const internalRenderExtraHeader = defaultRenderExtraHeader

const internalRenderExtraFooter = defaultRenderExtraFooter
const internalSubListsOf = defaultSubListsOf


const internalRenderTitle = (cardsData,targetComponent) =>{
  
  
  const linkComp=cardsData.returnURL?<Link to={cardsData.returnURL}> <FontAwesome name="arrow-left"  /> </Link>:null
  return (<div>{linkComp}{cardsData.cardsName}: {cardsData.displayName}</div>)

}


const internalSummaryOf = (review,targetComponent) =>{
	
	
	const {ReviewService} = GlobalComponents
	const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="Id">{review.id}</Description> 
<Description term="Title">{review.title}</Description> 
<Description term="User">{review.user==null?appLocaleName(userContext,"NotAssigned"):review.user.displayName}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"User","profile",ReviewService.requestCandidateUser,
	      ReviewService.transferToAnotherUser,"anotherUserId",review.user?review.user.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
<Description term="Product">{review.product==null?appLocaleName(userContext,"NotAssigned"):review.product.displayName}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"Product","product",ReviewService.requestCandidateProduct,
	      ReviewService.transferToAnotherProduct,"anotherProductId",review.product?review.product.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
<Description term="Update Time">{ moment(review.updateTime).format('YYYY-MM-DD')}</Description> 
	
        {buildTransferModal(review,targetComponent)}
      </DescriptionList>
	)

}


class ReviewDashboard extends Component {

 state = {
    transferModalVisiable: false,
    candidateReferenceList: {},
    candidateServiceName:"",
    candidateObjectType:"city",
    targetLocalName:"",
    transferServiceName:"",
    currentValue:"",
    transferTargetParameterName:"",  
    defaultType: 'review'


  }
  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const { id,displayName,  } = this.props.review
    if(!this.props.review.class){
      return null
    }
    const returnURL = this.props.returnURL
    
    const cardsData = {cardsName:"Review",cardsFor: "review",
    	cardsSource: this.props.review,returnURL,displayName,
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
  review: state._review,
  returnURL: state.breadcrumb.returnURL,
  
}))(Form.create()(ReviewDashboard))

