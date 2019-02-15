

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
import styles from './Blog.dashboard.less'
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


const imageList =(blog)=>{return [
	 ]}

const internalImageListOf = (blog) =>defaultImageListOf(blog,imageList)

const optionList =(blog)=>{return [ 
	]}

const buildTransferModal = defaultBuildTransferModal
const showTransferModel = defaultShowTransferModel
const internalSettingListOf = (blog) =>defaultSettingListOf(blog, optionList)
const internalLargeTextOf = (blog) =>{

	return(<div> 
   <Card title={`Content`} ><pre>{blog.content}</pre></Card>
</div>)

	

}


const internalRenderExtraHeader = defaultRenderExtraHeader

const internalRenderExtraFooter = defaultRenderExtraFooter
const internalSubListsOf = defaultSubListsOf


const internalRenderTitle = (cardsData,targetComponent) =>{
  
  
  const linkComp=cardsData.returnURL?<Link to={cardsData.returnURL}> <FontAwesome name="arrow-left"  /> </Link>:null
  return (<div>{linkComp}{cardsData.cardsName}: {cardsData.displayName}</div>)

}


const internalSummaryOf = (blog,targetComponent) =>{
	
	
	const {BlogService} = GlobalComponents
	const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="Id">{blog.id}</Description> 
<Description term="Title">{blog.title}</Description> 
<Description term="User">{blog.user==null?appLocaleName(userContext,"NotAssigned"):blog.user.displayName}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"User","profile",BlogService.requestCandidateUser,
	      BlogService.transferToAnotherUser,"anotherUserId",blog.user?blog.user.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
<Description term="Product">{blog.product==null?appLocaleName(userContext,"NotAssigned"):blog.product.displayName}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"Product","product",BlogService.requestCandidateProduct,
	      BlogService.transferToAnotherProduct,"anotherProductId",blog.product?blog.product.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
<Description term="Update Time">{ moment(blog.updateTime).format('YYYY-MM-DD')}</Description> 
	
        {buildTransferModal(blog,targetComponent)}
      </DescriptionList>
	)

}


class BlogDashboard extends Component {

 state = {
    transferModalVisiable: false,
    candidateReferenceList: {},
    candidateServiceName:"",
    candidateObjectType:"city",
    targetLocalName:"",
    transferServiceName:"",
    currentValue:"",
    transferTargetParameterName:"",  
    defaultType: 'blog'


  }
  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const { id,displayName,  } = this.props.blog
    if(!this.props.blog.class){
      return null
    }
    const returnURL = this.props.returnURL
    
    const cardsData = {cardsName:"Blog",cardsFor: "blog",
    	cardsSource: this.props.blog,returnURL,displayName,
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
  blog: state._blog,
  returnURL: state.breadcrumb.returnURL,
  
}))(Form.create()(BlogDashboard))

